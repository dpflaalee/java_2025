//step1) 초기값
export const initialState = {
  mainPosts:[{
    id:1
    ,User:{ id:1, nickname:'loud8633' } 
    ,content: '첫번째 게시글 #node #react' 
    ,Images : [
          {src:'https://images.pexels.com/photos/32111228/pexels-photo-32111228.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'},
          {src:'https://images.pexels.com/photos/32134450/pexels-photo-32134450.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'},
          {src:'https://images.pexels.com/photos/31665652/pexels-photo-31665652.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'}
    ]
    ,Comment : [{
      User:{nickname:'nori'}, content:'hi'
    },{
      User:{nickname:'henut'}, content: 'boo'
    }]
    ,postAdd:false
    ,imagePaths: []
  }],//E.mainPosts
};//E.initialState

export const addPost = {type:'ADD_POST', }

//////////더미데이터
const dummyPost ={
  id:2, content:'dummy'
  , User:{id:1, nickname:'loud8633'}
  , Images: []
  , Comment :[]
}
//////////더미데이터

//step3) 이전+상태 = 다음상태
export default( state=initialState, action ) => {
  switch(action.type){
    case 'ADD_POST' :
      return{
        ...state,
        mainPosts : [dummyPost, ...state.mainPosts] , // 맨앞으로
        //mainPosts : [...state.mainPosts, dummyPost] , // 맨뒤로
        postAdd : true,
      }
    default:{
      return {...state}
    }
  }
};