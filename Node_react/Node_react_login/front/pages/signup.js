import React, {useState, useCallback} from 'react';
import AppLayout from '../components/AppLayout';
import Head from 'next/head';
import {Form, Input, Button, Checkbox} from 'antd';
import userInput from '../hooks/userInput';
import styled from 'styled-components';

const ErrorMessage = styled.div`color:red;`;

const Singup = ()=>{
  ///////////////////////////////////////////////////////////////////code
  const [id, onChangeId] = userInput(''); // id와 function만 부여하면 hooks>userInput 에서 처리하여 값 반환
  //  const [nickname, setNickname] = useState('');
  //  const onChangeNickname = useCallback((e)=>{ setNickname(e.target.value) }, [] );  
  const [nickname, onChangeNickname] =userInput('');
  const [password, onChangePassword] = userInput('');
  //const [passwordRe, onChangePasswordRe] = userInput('');

  const[passwordRe, setonChangePasswordRe] = useState('');
  const [passwordError, setPasswordError] = useState(false);
  const onChangePasswordRe = useCallback((e)=>{
    setonChangePasswordRe(e.target.value);
    setPasswordError(e.target.value !== password);
  }, [password])

  const [check, setCheck] = useState('');
  const [checkError, setCheckError] = useState(false);
  const onChangeCheck = useCallback((e)=>{
    // console.log(e.target.checked);
    setCheck(e.target.checked);
    setCheckError(false);
  }, []);

  const onSubmitForm = useCallback(()=>{
    if(password !== passwordRe){ return setPasswordError(true); }
    if(!check){setCheckError(true);}
  }, [id, password, passwordRe, check]);

  ///////////////////////////////////////////////////////////////////view
  return(
  <>
    <Head>
      <meta charset="utf-8" />
      <title>signup | TheJoa</title>
    </Head>
    <AppLayout>
      <Form layout='vertical' style={{margin:"2%"}} onFinish={onSubmitForm}>
        <Form.Item>
          <label htmlFor='id'>이메일</label>
          <Input placeholder='user@mail.com' id='id' 
          value={id} onChange={onChangeId} name='id' required/>
        </Form.Item>
        <Form.Item>
          <label htmlFor='nickname'>닉네임</label>
          <Input placeholder='닉네임을 작성해주세요' id='nickname' 
          value={nickname} onChange={onChangeNickname} name='nickname' required/>
        </Form.Item>   
        <Form.Item >
          <label htmlFor='password'>비밀번호</label>
          <Input type='password' placeholder='비밀번호입력' id='password' 
          value={password} onChange={onChangePassword} name='password' required/>
        </Form.Item>             
        <Form.Item>
          <label htmlFor='passwordRe'>비밀번호 확인</label>
          <Input type='password' placeholder='비밀번호 확인' id='passwordRe' 
          onChange={onChangePasswordRe} name='passwordRe' required/>
          {passwordError && <ErrorMessage>비밀번호를 확인해주세요</ErrorMessage> }
        </Form.Item>    

        <Form.Item>
          <label htmlFor='check'>TheJoA는 회원들의 권리를 지킵니다. 약관 내용입니다.</label>
          <Checkbox id='check' name='check' checked={check} onChange={onChangeCheck} />
          {checkError && <ErrorMessage>약관에 동의하셔야 합니다.</ErrorMessage>}
        </Form.Item>
        <Form.Item>
          <Button type='primary' htmlType='submit'>회원가입</Button>
        </Form.Item>
      </Form>
    </AppLayout>
  </>);
};
export default Singup;