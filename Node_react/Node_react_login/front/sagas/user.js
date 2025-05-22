// 1) 초기값
export const initialState = {
  logInLoding: false,   // 로그인 시도중    - 로딩창
  logInDone: false, 
  logInError: null,   
    
  logOutLoding: false,   // 로그인 시도중    - 로딩창
  logOutDone: false, 
  logOutError: null,   

  user: null,
  signUpData: {},
  loginData: {}
};
// 2) action
export const loginAction = (data) => {
  return {
     type: 'LOG_IN_REQUEST',
     data,
  }
};
export const logoutAction = {
  type: 'LOG_OUT_REQUEST',
};

export default (state = initialState, action) => {
  switch (action.type) {
     case 'LOG_IN_REQUEST':
        return {
          ...state,    //  이전
          logInLoding: true,   // 로그인 시도중    - 로딩창
          logInDone: false, 
          logInError: null,   
        }
     case 'LOG_IN_SUCCESS':
         return {
            ...state,    //  이전
            logInLoding: false,   // 로그인 시도중    - 로딩창
            logInDone: true,  
            user : { ...action.data , nickname:'sally' }
        }
     case 'LOG_IN_FAILURE':
         return {
            ...state,    //  이전
            logInLoding: false,   // 로그인 시도중    - 로딩창 
            logInError: action.error,   
         }     
      case 'LOG_OUT_REQUEST':
         return {
            ...state,    //  이전
            logOutLoding: true,   // 로그인 시도중    - 로딩창
            logOutDone: false, 
            logOutError: null,   
         }
      case 'LOG_OUT_SUCCESS':
         return {
            ...state,    //  이전
            logOutLoding: false,   // 로그인 시도중    - 로딩창
            logOutDone: true,   
            user : null
         }
      case 'LOG_OUT_FAILURE':
         return {
            ...state,    //  이전
            logOutLoding: false,  
            logOutError : action.error
         }     
     default: {
        return {
           ...state,
        }
     }
  }
};