import React from "react";
import { Form, Input } from "antd";

const NicknameForm = ()=>{
  return(
  <Form style={{margin:'5%', padding:'20px'}}>
    <Input.Search addonBefore="닉네임" enterButton="수정" />
  </Form>)
}

export default NicknameForm;