//step1) 초기값
export const initialState = { 
    isLogin:false,
    user: null,
    signupDate: {},
    loginData: {} ,
}; //E.initialState

//step2) 로그인할때마다 설정 함수
export const loginAction = ( data )=>{ 
  return{type:'LOG_IN', data, }
 };  // E.login
export const logoutAction = {
  type: 'LOG_OUT',
}; // E.logout

//step3) 이전+상태 = 다음상태
export default ( state=initialState, action ) => { 
   switch(action.type){ 
    case 'LOG_IN' ://액션 
      return{  
        ...state, //이전상태
        isLogin:true,
        user: action.data //다음상태
      }
    case 'LOG_OUT' : 
      return{ 
        ...state,        
        isLogin:false,
        user: null ,      
     }
    default :
      return{...state}
  }  
}; //E.export