import React from 'react';
import AppLayout from '../components/AppLayout';
import PostCard from '../components/PostCard';
import PostForm from '../components/PostForm';

//import 'antd/dist/antd.css';
const Home = ()=>{
  return(<AppLayout>
    <PostForm />
    <PostCard />
  </AppLayout>);
};
export default Home;