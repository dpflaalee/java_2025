import { all, put, fork, takeLatest, delay } from 'redux-saga/effects' // # 1.

//////
function addpostApi(data) {  return axios.POST('/post');  } 
function*addpost(action) {
    //const result = yield call(addpostApi, action.data); // 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'ADD_POST_SUCCESS',
            data: action.data
        })

    } catch (error) {
        yield put({
            type: 'ADD_POST_FAILURE',
            data: error.response.data
        })
    }
}
//-
function addCommentApi(data) {  return axios.POST('/post/comment', data);  } 
function*addComment(action) {
    try {
        yield delay(1000);
        yield put({
            type: 'ADD_COMMENT_SUCCESS',
            data: action.data
        })

    } catch (error) {
        yield put({
            type: 'ADD_COMMENT_FAILURE',
            data: error.response.data
        })
    }
}
///step2) ACTION 기능추가
function*watchAddPost() {
    //yield take('ADD_POST', addpost);    // ㅍㄷㄱ 1take는 일회용 - 로그인 1번, 게시글도 1번만
    yield takeLatest('ADD_POST_REQUEST', addpost); // ver 2 3번 요청 => 응답 1번
    // yield throttle('ADD_POST', addpost, 10000); ver3 몇초뒤에 실행, 시간 설정 가능 - 10초 뒤에 
}
//ADD_COMMENT_REQUEST
//function*addComment(){
//    yield takeLatest('ADD_COMMENT_REQUEST', addComment);
//}

//// step1) all()
export default function*postSaga() {
    yield all([// all - 동시에 배열로 받은 fork들을 동시에 실행해줌 
        fork(watchAddPost), // fork - generator 함수들을 실행해줌.
        fork(addComment), 
    ]);
}