import { all, put, delay, fork, takeLatest, call } from 'redux-saga/effects'  //#1
import axios from 'axios';

import {
  LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,

  LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,

  SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
  
  CHANGE_NICKNAME_REQUEST, CHANGE_NICKNAME_SUCCESS,  CHANGE_NICKNAME_FAILURE,

  FOLLOW_REQUEST,  FOLLOW_SUCCESS, FOLLOW_FAILURE,

  UNFOLLOW_REQUEST, UNFOLLOW_SUCCESS, UNFOLLOW_FAILURE,

  generateDummyPost

} from '../reducers/user';

///// step3) 
function  loginApi(data) {  
  return axios.post('/user/login' , data);
}
function* login(action) {
  try {
    const result = yield call( loginApi, action.data ); 
    //yield delay(1000);
    yield put({
      type: LOG_IN_SUCCESS,
      data: result.data  // action.data 
    })
   console.log('........ login success');
  } catch (error) {
    yield put({
      type: LOG_IN_FAILURE,
      data: error.response.data
    })
   console.log('........ login error');
  }
}
//--
function  logoutApi() {   
  return axios.post('/user/logout');
}
function* logout() {
  try {
    const result = yield call( logoutApi); 
    //yield delay(1000);
    yield put({
      type: LOG_OUT_SUCCESS,
    })
  } catch (error) {
    yield put({
      type: LOG_OUT_FAILURE,
      data: error.response.data
    })
  }
}

//--
function  signUpApi(data) {  return axios.post('/user', data); }
function* signUp(action) {
  try {
    const result = yield call( signUpApi, action.data); 
    //yield delay(1000);
    console.log(result.data);
    yield put({
      type: SIGN_UP_SUCCESS, 
      data: result.data
    })
  } catch (error) {
    yield put({
      type: SIGN_UP_FAILURE,
      data: error.response.data
    })
  }
}
// changeNickname 
//--
function  changeNicknameApi( data ) {   //★   function* (X)
  return axios.post('/user/nickname'  , {nickname : data});
}
function* changeNickname(action) {
  //const result = yield call( logoutApi); 처리함수, 처리파라미터
  try {
    yield delay(1000);
    yield put({
      type: CHANGE_NICKNAME_SUCCESS, 
      data: action.data
    })
  } catch (error) {
    yield put({
      type: CHANGE_NICKNAME_FAILURE,
      data: error.response.data
    })
  }
}
///// step2) ACTION 기능추가
function* watchLogin() {
  yield takeLatest(LOG_IN_REQUEST, login );  //LOG_IN 액션이 실행될때까지 기다리기
}
function* watchLogout() {
  yield takeLatest(LOG_OUT_REQUEST, logout);

}
function* watchSignup() {
  yield takeLatest(SIGN_UP_REQUEST, signUp);  //요청 10 ->응답1
}
function* watchChangeNickname() {
  yield takeLatest(CHANGE_NICKNAME_REQUEST, changeNickname);  //요청 10 ->응답1
}
///// step1) all()
export default function* userSaga() {
  yield all([
      fork(watchLogin),
      fork(watchLogout),
      fork(watchSignup), 
      
      fork(watchChangeNickname),
  ]);
}
