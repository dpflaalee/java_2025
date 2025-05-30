import React, {useState, useEffect} from "react";
import {useRouter} from 'next/router';
import axios from 'axios';

import AppLayout from '../../components/AppLayout';
import PostCard from '../../components/PostCard';

const HashTag = () => {
  const router = useRouter();
  const{tag} = router.query;
  const[mainPosts, setMainPosts] = useState([]);
  const[hasMorePosts, setHasMorePosts] = useState([]);
  const[loading, setLoading] = useState(true);
  const[error, setError] = useState(null);
  
useEffect( ()=>{ 
    ////////// axios
      const fetchData=async()=>{ // 중앙저장소 안쓰고 불러오는 방법
        try{
          setLoading(true);
          const response = await axios.get(
            `http://localhost:3065/hashtag/${tag}`, {withCredentials:true} );
          setMainPosts(response.data);
          setHasMorePosts(response.data.length>0);

        }catch(err){ setError(err)} finally{ setLoading(false); }
      };
      if(tag){fetchData();} 
} ,[tag]);

  // 스크롤
  useEffect(()=>{
    function onScroll(){
      //             내가 내린 길이     화면이 보에는 높이      = 브라우저 길이
      console.log(window.screenY, document.documentElement.clientHeight, document.documentElement.scrollHeight)
      // screenY VS pageYOffset
      //screenY     : 현재창에서 마우스커서 Y  : 랜덤
      //pageYOffset : 페이지를 스크롤 측정 Y   : 일정
      if( window.screenY + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200 ){
        if(hasMorePosts && !loading){
          axios.get( `http://localhost:3065/hashtag/${tag}?lastId=${mainPosts[mainPosts.length-1]?.id}`, {withCredentials:true} )
            .then( (response)=>{
              setMainPosts( (prev)=> [...prev, ...response.data] );
              setHasMorePosts( response.data.length>0 );
            } )
            .catch((err)=>setError(err));
        }
      }
    }
    window.addEventListener('scroll', onScroll);
    return()=>{
      window.removeEventListener('scroll', onScroll);//스크롤했던거 지우기
    }
  },[mainPosts, hasMorePosts, tag, loading])

  if(loading){ return <div>게시글 불러오는 중</div>; }
  if(error){ return <div>Error!</div>; }

  /////////////////////////////////////////////////////////
  return (<AppLayout> 
    { mainPosts.map((c) => {
      return ( <PostCard   post={c}  key={c.id} />  );} )} 
  </AppLayout>);  
}

export default HashTag;