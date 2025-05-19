import React, { useState , useCallback } from "react";
import {Input, Button, Form, Row, col} from 'antd'
import Link from 'next/Link';
const LoginForm = ()=>{
  //////////////////////////////////////////////////code
  const[id, setId] = useState(''); // 상태관리 - component(변수) 값이 변경될 때
  const onChangeId = useCallback((e)=>{ // function(함수) 함수의 재생성
    //console.log(e.target.value);
    setId(e.target.value);
  }, []); 
   const[password, setPassword] = useState('');
   const onChangePassword = useCallback((e)=>{
    console.log(e.target.value);
    setPassword(e.target.value);
   });

   //Q. 로그인버튼 클릭 시 - count의 숫자 증가 console 숫자증가 (useState)
   const[count , setCount] = useState(0);
   const onCount = (e)=>{
     setCount(count+1);
     console.log(count);
   };

  //////////////////////////////////////////////////view
  return(
    <>
      <Form layout="vertical" style={{padding:'3% 10%'}}>
        <Form.Item label="아이디" >
          <Input  placeholder="user@gmail.com 형식으로 입력" name="id" value={id}
          onChange={onChangeId} required/>
        </Form.Item>
        <Form.Item label="비밀번호">
          <Input.Password placeholder="비밀번호 입력"  name="password"  value={password} onChange={onChangePassword}/>
        </Form.Item>
        <Form.Item style={{textAlign:'right'}}>
          <Link href="/signup" legacyBehavior><Button>회원가입</Button></Link>
          <Button type="primary" style={{marginLeft: '4%'}} 
          onClick={onCount}>로그인{count}</Button>
        </Form.Item>                        
      </Form>
    </>
  );
};

export default LoginForm;