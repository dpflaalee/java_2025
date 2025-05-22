import {all, call, fork, takeLatest, put, delay}  from 'redux-saga/effects'  //#1

//step3) 
function addpostApi(data){ return axios.POST('/post'); }
function*addpost(action){ 
  //const result = yield call(addpostApi, action.data);
  try{
    yield delay(1000);
    yield put({
      type : 'ADD_POST_SUCCESS'
      ,data : result.data //result.data
    })
  }catch(error){
    yield put({
      type : 'ADD_POST_FAILURE'
      ,data : error.response.data
    })  
  }
}

//step2) ACTION 뒤에 기능 추가
function* watchAddPost() { 
//  yield take('ADD_POST', addpost ); ver1
  //단점 : take는 일회용 -- 로그인 1번, 게시글도 1번만
  //해결 : 반복문(while) 사용(비추천?) or takeLatest

  yield takeLatest('ADD_POST', addpost );  // ver2 3번요청 -> 응답 1번

  //yield throttle('ADD_POST', addpost, 10000); //ver3 10초 뒤에 실행(시간설정가능)
  //2, 3을 많이 사용함
} 

///// step1) all()
export default function* postSaga() { 
  yield all([
    fork(watchAddPost) 
  ]);
}