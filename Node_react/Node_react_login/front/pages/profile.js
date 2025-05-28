import React , {useState, useCallback, useEffect} from 'react';
import AppLayout from '../components/AppLayout'
import Head from 'next/head';
import NickNameForm from '../components/NickNameForm';
import FollowList   from '../components/FollowList';
import { useSelector } from 'react-redux';
import Router from 'next/router';
import axios from 'axios';

// --
const Profile = () => { 
  /*const data = [{ nickname: 'Title 1', }, { nickname: 'Title 2', }, { nickname: 'Title 3', }, { nickname: 'Title 4', },]; */ //더미데이터
  const {user} = useSelector(state=>state.user); // 중앙저장소에서 user
  const [followersLimit, setFollowersLimit] = useState(3);  // 3,6,9,12....
  const [followingsLimit, setFollowingsLimit] = useState(3);
  const [followersData, setFollowersData] = useState([]); // setFollowersData 있어야하고 setError가 없어야 함
  const [followingsData, setFollowingsData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  //1. 유저 있는지 확인 
  useEffect(()=>{ if(!(user&&user.id)){ Router.push('/'); } }, [user&&user.id]);  
  //2. 유저호출 (3명씩 불러서 데이터 가져오기)
  useEffect( ()=>{
    ////////// axios
    const fetchData=async()=>{ // 중앙저장소 안쓰고 불러오는 방법
      try{
        setLoading(true);

        const followersResponse = await axios.get(
          `http://localhost:3065/user/followers?limit=${followersLimit}`,{withCredentials:true}
        );
        const followingsResponse = await axios.get(
          `http://localhost:3065/user/followings?limit=${followingsLimit}`, {withCredentials:true}
        );

        setFollowersData(followersResponse.data);
        setFollowingsData(followingsResponse.data);
      }catch(err){ setError(err)} finally{ setLoading(false); }
    };
    fetchData();

  } ,[followersLimit, followingsLimit] );
  //3. 3명씩 followingsData 추가 
  const loadMoreFollowings = useCallback( ()=>{ setFollowingsLimit(prev=>prev+3); }, [] );
  //4. 3명씩 followersData추가
  const loadMoreFollowers = useCallback( ()=>{ setFollowersLimit(prev=>prev+3); } );

  if(!user){ return "<div>.........loading</div>"; }
  if(error){ console.error(error); return "<div style='color: red; font-whight: bold;'>로딩 중 에러발생!</div>" }
  
  //////////////////////////////////////////////////////////////view
  return (
    <>
      <Head>
        <meta charSet="utf-8"/>
        <title> Profile | TheJoa </title>
      </Head>
      <AppLayout>
        <NickNameForm/>
        <FollowList  header="팔로잉"  data={followingsData} onClikMore={loadMoreFollowings} loading={ !followersData && !error } />
        <FollowList  header="팔로우"  data={followersData} onClikMore={loadMoreFollowers} loading={ !followersData && !error }  />
      </AppLayout>
    </>
  );
}
export default Profile;
