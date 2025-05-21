import {HYDRATE} from 'next-redux-wrapper'; // redux 상태를 서버에서 생성, 클라이언트에 전달

import { combineReducers } from 'redux';
import user from './user';
import post from './post';

const rootReducer = combineReducers({
  index : ( state={}, action )=>{ 
    switch(action.type){
      case HYDRATE: 
      console.log('HYDRATE', action);
      return{ ...state, ...action.playload};
      default :
        return{...state}
    }//E.switch    
   }  ,
  user,
  post,
});//E.rootReducer
export default rootReducer;




/////////////////////////////////////////////////////분리 전

/*
//step1) 초기값
const initialState = {
  user: {
    isLogin:false,
    user: null,
    signupDate: {},
    loginData: {}
  },
  post: {}
}; //E.initialState


//step2) 로그인할때마다 설정 함수
export const loginAction = ( data )=>{ 
  return{type:'LOG_IN', data, }
 };  // E.login
export const logoutAction = {
  type: 'LOG_OUT',
}; // E.logout
*/
//step3) 이전상태 + 액션 = 다음 상태  (이벤트)


