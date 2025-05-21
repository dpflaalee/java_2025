import { Form, Input, Button } from "antd";
import React, { useCallback, useState, useRef } from "react";
//1. useDispatch, useSelector
import { useDispatch, useSelector } from "react-redux";
//2. addPost
import { addPost } from "../reducers/post";

const PostForm = ()=>{
//3. useSelector 이용해서 post 가져오기
const {imagePaths} = useSelector(state => state.post)
const imageInput = useRef();
const onCilckImageUpload = useCallback( ( )=>{
//  imageInput.current.cilck();
}, [imageInput.current]);

//4. dispatch ( 글 )
const dispatch = useDispatch();
const [text, setText] = useState('');
const onChangeText = useCallback((e)=>{
  console.log("..........."+e.target.value);
  setText(e.target.value);
},[]);
const onFormSubmit = useCallback( ()=>{
  dispatch(addPost);
  setText('');
}, [] )
//5. 이벤트
  ///////////////////////////////////view
  return(<Form layout="vertical" style={{padding:'3%', backgroundColor:'white'}} 
          encType="multipart/form-data"
          onFinish={onFormSubmit}>
    <Form.Item label="글쓰기" name="text">
      <Input.TextArea placeholder="게시글을 적어주세요" maxLength={200} style={{resize:"none"}}
        value={text} onChange={onChangeText} />
    </Form.Item>
    <Form.Item>
      <Input type="file" name="image" multiple hidden/>
      <Button onClick={onCilckImageUpload} multiple hidden ref={onCilckImageUpload} style={{display:"none"}}>이미지 업로드</Button>
      <Button type="primary" style={{float:'right'}} htmlType="submit">Post</Button>
    </Form.Item>
    {/* <div>
      { imagePaths.map((v, i)=>(
        <div key={v}>
          <img src={v} style={{width:'200px'}} />
          <div><Button>제거</Button></div>
        </div>
      )) }
    </div> */}
  </Form>);
}

export default PostForm;