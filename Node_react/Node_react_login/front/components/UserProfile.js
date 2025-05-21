import React , {useCallback} from "react";
import{Card, Avatar, Button} from 'antd';
import styled from 'styled-components';
import { logoutAction } from "../reducers/user"; //#redux logout
import { useDispatch } from "react-redux";  //#redux logout

const ButtonWrapper = styled.div`
  margin-top:15%;
`;

const UserProfile=()=>{ //#3. redux {setIsLogin} 삭제
  /////////////////////////////////////////code
  //로그아웃 버튼 누르면 로그아웃되게 만들기
  const dispatch = useDispatch(); //#4. redux
  const onLogOut = useCallback(()=>{
    //setIsLogin(false);
    dispatch(logoutAction); //#5. redux
  },[]);

  /////////////////////////////////////////view
  return(
    <Card
      actions={[
        <div key="sns">게시글<br/>0</div>
        ,<div key="followings">팔로잉<br/>0</div>
        ,<div key="followers">팔로워<br/>0</div>
      ]}
    >
      <Card.Meta avatar={<Avatar>Thejoa</Avatar>} title='TheJoA' />
      <ButtonWrapper>
      <Button onClick={onLogOut} >로그아웃</Button>
      </ButtonWrapper>
    </Card>
  );
};

export default UserProfile;