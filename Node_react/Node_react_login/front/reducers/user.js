export const initialState = {
  isLoggingIn: false, //로그인 시도중
  isLoggedIn: false, 
  isLoggingOut: false, //로그아웃 시도중
  user: null,
  signUpData: {},
  loginData: {}
};

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
          ...state,  
          isLoggingIn: true, //로그인 시도중 
        }
     case 'LOG_IN_SUCCESS':
        return {
          ...state,  
          isLoggingIn: false, //로그인 시도중  
          isLoggedIn: true, 
          user: {...action.data, nickname:'sally'}
        }
     case 'LOG_IN_FAILURE':
        return {
          ...state,  
          isLoggingIn: false, //로그인 시도중  
          isLoggedIn: false 
        }   
        
     case 'LOG_OUT_REQUEST':
        return {
          ...state,  
          isLoggingOut: true, //로그아웃 시도중 
        }
     case 'LOG_OUT_SUCCESS':
        return {
          ...state,  
          isLoggingOut: false, //로그아웃 시도중  
          isLoggedIn: false, 
          user: null
        }
     case 'LOG_OUT_FAILURE':
        return {
          ...state,  
          isLoggingOut: false, //로그아웃 시도중   
        }           
     default: {
        return {
           ...state,
        }
     }
  }
};