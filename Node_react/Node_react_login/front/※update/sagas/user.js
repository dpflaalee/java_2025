import { all, put, delay, fork, takeLatest } from 'redux-saga/effects'  //#1
///// step3) 
function loginApi(data) {   //★   function* (X)
    return axios.POST('/user/login', data);
}
function* login(action) {
    //const result = yield call( loginApi, action.data ); 처리함수, 처리파라미터
    try {

        yield delay(1000);
        yield put({
            type: 'LOG_IN_SUCCESS',
            data: action.data   // result.data
        })

        console.log('........ login success');
    } catch (error) {
        yield put({
            type: 'LOG_IN_FAILURE',
            data: error.response.data
        })

        console.log('........ login error');
    }
}
//--
function logoutApi() {   //★   function* (X)
    return axios.POST('/user/logout');
}
function* logout() {
    //const result = yield call( logoutApi); 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'LOG_OUT_SUCCESS',
            // data: result.data   // result.data
        })
    } catch (error) {
        yield put({
            type: 'LOG_OUT_FAILURE',
            data: error.response.data
        })
    }
} 
//--
function signUpApi() {   //★   function* (X)
    return axios.POST('/user/singUp');
}
function*signUp() {
    //const result = yield call( signUpApi); 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'SIGN_UP_SUCCESS',
            // data: result.data   // result.data
        })
    } catch (error) {
        yield put({
            type: 'SIGN_UP_FAILURE',
            data: error.response.data
        })
    }
} 

///// step2) ACTION 기능추가
function* watchLogin() {
    yield takeLatest('LOG_IN_REQUEST', login);  //LOG_IN 액션이 실행될때까지 기다리기
}
function* watchLogout() {
    yield takeLatest('LOG_OUT_REQUEST', logout);
}
function*watchSignup(){
   yield takeLatest('SIGN_UP_REQUEST', signUp); // 요청 10 -> 응답 1번
}

///// step1) all()
export default function* userSaga() {
    yield all([
        fork(watchLogin),
        fork(watchLogout),
        fork(watchSignup)
    ]);
}