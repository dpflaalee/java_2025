import React, {useEffect} from 'react';
import AppLayout from '../components/AppLayout'
//import  'antd/dist/antd.css';
import PostForm from '../components/PostForm';
import PostCard from '../components/PostCard';

import { useSelector, useDispatch } from 'react-redux';  //##
import { LOAD_POSTS_REQUEST } from '../reducers/post';

const Home = () => { 
  const dispatch = useDispatch();
  const { user }   = useSelector(state => state.user); 
  const { mainPosts, hasMorePosts, loadPostsLoading } = useSelector(state => state.post);

  useEffect(()=>{
    if(hasMorePosts && !loadPostsLoading){
      const lastId = mainPosts[mainPosts.length-1]?.id;
      dispatch({
        type: LOAD_POSTS_REQUEST,
        lastId,
      })
    }
  },[mainPosts, hasMorePosts, loadPostsLoading]);

  // 스크롤 내려 맨끝가면 다시 로딩
  useEffect(()=>{
    function onScroll(){
      //             내가 내린 길이     화면이 보에는 높이      = 브라우저 길이
      console.log(window.screenY, document.documentElement.clientHeight, document.documentElement.scrollHeight)
      // 내가 내린길이 + 화면에 보이는 높이 > 브라우저길이-200px(브라우저길이보다 200px 크면)
      if( window.screenY + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200 ){
        if(hasMorePosts && !loadPostsLoading){
          dispatch({
            type: LOAD_POSTS_REQUEST,
            data:mainPosts[mainPosts.length-1]?.id,
          })
        }
      }
    }
    window.addEventListener('scroll', onScroll);
    return()=>{
      window.removeEventListener('scroll', onScroll);//스크롤했던거 지우기
    }
  },[mainPosts, hasMorePosts, loadPostsLoading]) 
  
  return (<AppLayout> 
    { user &&  <PostForm /> }
    { mainPosts.map((c) => {
      return (
        <PostCard   post={c}  key={c.id} />
      );} )}
      
  </AppLayout>);
}
export default Home;