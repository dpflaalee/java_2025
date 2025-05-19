import React, {useState} from "react";
import PropTypes from 'prop-types'
import Link from 'next/Link';
import {Menu, Input, Row, Col} from 'antd';
import UserProfile from "./UserProfile";
import LoginForm from "./LoginForm";

const AppLayout = ({children})=>{
  ////////////////////////////////////code
  const items=[
     {label:<Link href="/" legacyBehavior>Logo</Link>, key:'/'}
    ,{label : <Link href="/profile" legacyBehavior>프로필</Link>, key:'/profile'}
    ,{label : <Link href="/signup" legacyBehavior>회원가입</Link>, key:'/signup'}
    ,{label : <Input.Search 
               placeholder="input search text" 
               enterButton
               style={{verticalAlign:'middle'}}/>, key : '/search'}
  ];

  /* 1. 변수 vs ★ useState ★ */
  //let logo = "My React";
  //const changeLogo =()=>{console.log('.......로고바꾸기'); logo="welcome!";}
  // 단순 대입 시 state 값의 변경점을 reactDom이 알지 못함
  let [logo, setLogo] = useState('Logo'); // [logo : 변수초기값, setLogo: 함수를 통해서 재렌더링]
  const changeLogo = ()=>{console.log('.......로고바꾸기'); setLogo('★Login★');}

  /*2. login 상태 */
  const [isLoggin, SetIsLogin] = useState(false);

  ////////////////////////////////////view
  return(
    <div>
      <Menu mode = "horizontal" items={items}/>
      <Row gutter ={8}>
        <Col xs={24} md={6}>
          {/*<h3 onClick={ ()=>{ console.log('......'); } }>{logo}</h3>*/}
          {/*<h3 onClick={changeLogo}>{logo}</h3>*/}
          { isLoggin? <UserProfile/> : <LoginForm/> }
        </Col>
        <Col xs={24} md={12} style={{backgroundColor:'#efefef'}}>{children}</Col>
        <Col xs={24} md={6}><div>
          <a href="http://thejoa.com" target="_blank" rel="noreferrer noopener">Thejoa</a>
          copyrights. all reserved</div>
        </Col>
      </Row>
    </div>);
};

AppLayout.prototype={children : PropTypes.node.isRequired};

export default AppLayout;