export const initialState = {
   mainPosts: [{
        id: 1
      , User: { id: 1, nickname: 'sally03915' }
      , content: '첫번째 게시글   #node  #react' 
      , Images: [
                 { src: 'https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png' },
                 { src: 'https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png' },
                 { src: 'https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png' },
      ] 
      , Comments: [{
            User:{nickname:'one'} , content:'hello'
          }, {
            User:{nickname:'two'} , content:'hi'
          }]
   }], 
   /////////////////////////// 추가 START
   //postAdd: false,
   imagePaths: [],
   hasMorePosts: true,

   loadPostsLoading: false,
   loadPostsDone: false,
   loadPostsError: null,

   addPostLoading: false,
   addPostDone: false,
   addPostError: null,

   removePostLoading: false,
   removePostDone: false,
   removePostError: null,

   addCommentLoading: false,
   addCommentDone: false,
   addCommentError: null,
   /////////////////////////// 추가 END   
}

////////////////////////////////////////////////////// action
export const addPost = {  type:'ADD_POST', }

//////////  dummyPost
const dummyPost = (data)=>({
   id:shortId.generate(),
   content:  data, 
   User: { id:1, nickname:'sally03915'  },
   Images: [], 
   Comments : []
});

const dummyComment = (data)=>({
   id:shortId.generate(),
   content: data, 
   User: { id:1, nickname:'sally03915'  }, 
});

export const LOAD_POSTS_REQUEST = 'LOAD_POSTS_REQUEST';
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS';
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE';

export const ADD_POST_REQUEST = 'ADD_POST_REQUEST';
export const ADD_POST_SUCCESS = 'ADD_POST_SUCCESS';
export const ADD_POST_FAILURE = 'ADD_POST_FAILURE';

export const REMOVE_POST_REQUEST = 'REMOVE_POST_REQUEST';
export const REMOVE_POST_SUCCESS = 'REMOVE_POST_SUCCESS';
export const REMOVE_POST_FAILURE = 'REMOVE_POST_FAILURE';


export const ADD_COMMENT_REQUEST = 'ADD_COMMENT_REQUEST';
export const ADD_COMMENT_SUCCESS = 'ADD_COMMENT_SUCCESS';
export const ADD_COMMENT_FAILURE = 'ADD_COMMENT_FAILURE';

////////////////////////////////////////////////////// next 
export default (state = initialState, action) => {
   switch (action.type) {
      /////////////  ADD_COMMENT start
      case ADD_COMMENT_REQUEST:
         return {
            ...state,  //prev(1)
            addCommentLoading: true,
            addCommentDone: false,
            addCommentError: null, //바뀐상태(2) = next(3)
         } 
      case ADD_COMMENT_SUCCESS:
         //1. postIndex 해당글가져오기  
         const postIndex = state.mainPosts.findIndex((v) => v.id === action.data.postId);
         const post = { ...state.mainPosts[postIndex] };
         //2. post.Comments
         post.Comments = [dummyComment(action.data.content), ...post.Comments];
         //3. mainPosts 추가
         const mainPosts = [...state.mainPosts];
         mainPosts[postIndex] = post;
         return {
            ...state, 
            mainPosts,  //##
            addCommentLoading: false,
            addCommentDone: true,
         }
      case ADD_COMMENT_FAILURE:
         return {
            ...state,  //prev(1) 
            addCommentLoading: false,
            addCommentError: action.error,  //바뀐상태(2) = next(3)
         } 
      /////////////  ADD_COMMENT end
      case ADD_POST_REQUEST:
         return {
            ...state,  //prev(1)
            addPostLoading: true,
            addPostDone: false,
            addPostError: null,   //바뀐상태(2) = next(3)
         } 
      case ADD_POST_SUCCESS:
         return {
            ...state,  //prev(1)
            mainPosts : [dummyPost(action.data), ...state.mainPosts], 
            addPostLoading: false,
            addPostDone: true,  //바뀐상태(2) = next(3)
         }   
      case ADD_POST_FAILURE:
         return {
            ...state,  //prev(1) 
            addPostLoading: false,
            addPostError: action.error,  //바뀐상태(2) = next(3)
         } 
/////////////////////////////////////////////////////////Removepost
      case REMOVE_POST_REQUEST:
         return {
            ...state, 
            removePostLoading: true,
            removePostDone: false,
            removePostError: null,            
         }
      case REMOVE_POST_SUCCESS:
         return {
            ...state, 
            mainPosts : state.mainPosts.filter(v=>v.id!==action.data),
            removePostLoading: false,
            removePostDone: true,       
         }
      case REMOVE_POST_FAILURE:
         return {
            ...state, 
            removePostLoading: false,
            removePostError: action.error,            
         }          
     default: {
        return {
           ...state,
        }
     }
  }
};