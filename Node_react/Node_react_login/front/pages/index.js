import React from 'react';
import AppLayout from '../components/AppLayout';
import PostCard from '../components/PostCard';
import PostForm from '../components/PostForm';
import { useSelector } from 'react-redux';

//import 'antd/dist/antd.css';
const Home = ()=>{
  const {isLogin} = useSelector( state => state.user );
  const {mainPosts} = useSelector(state=>state.post)

  return(<AppLayout>
    {isLogin && <PostForm />}
    {  mainPosts.map( (c)=>{ 
      return(
        <PostCard post={c} key={c.id} />
      ); 
    })}
  </AppLayout>);
};
export default Home;