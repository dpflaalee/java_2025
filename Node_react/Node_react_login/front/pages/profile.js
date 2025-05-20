import React from 'react';
import AppLayout from '../components/AppLayout';
import Head from 'next/head';
import NicknameForm from '../components/NicknameForm';
import FollowList from '../components/FollowList'

const Profile = ()=>{
  const data = [ { 'nickname':'title1' }, { 'nickname':'title2' }, { 'nickname':'title3' }, { 'nickname':'title4' } ]

  return(
  <>
    <Head>
      <meta charset="utf-8" />
      <title>Profile | TheJoa</title>
    </Head>
    <AppLayout>
      <NicknameForm></NicknameForm>
      <FollowList header="팔로잉" data={data} />
      <FollowList header="팔로워" data={data} />
    </AppLayout>
  </>
  );
};
export default Profile;