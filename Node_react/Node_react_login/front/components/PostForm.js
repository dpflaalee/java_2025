import { Form, Input, Button } from "antd";
import React from "react";
const PostForm = ()=>{
  ///////////////////////////////////view
  return(<Form layout="vertical" style={{padding:'3%', backgroundColor:'white'}}>
    <Form.Item label="글쓰기" name="text">
      <Input.TextArea placeholder="게시글을 적어주세요" maxLength={200} style={{resize:"none"}} />
    </Form.Item>
    <Form.Item>
      <Input type="file" name="image" multiple hidden/>
      <Button>이미지 업로드</Button>
      <Button type="primary" style={{float:'right'}} htmlType="submit">Post</Button>
    </Form.Item>
  </Form>);
}

export default PostForm;