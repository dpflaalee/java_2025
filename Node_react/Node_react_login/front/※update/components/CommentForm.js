import { Button, Input, Form } from "antd";
import React, { useCallback } from "react";
import PropTypes from "prop-types";
import userInput from '../hooks/userInput';
import { useSelector, useDispatch } from "react-redux";

//1. ADD_COMMENT_REQUEST
import { ADD_COMMENT_REQUEST } from "../reducers/post"; 
//2. useDispatch, use Selector

const CommentForm = ({post})=>{ // 어떤 게시글에 대한 댓글인가
  //3. addCommentLoading addCommentDone
  const {addCommentLoading, addCommentDone} = useSelector(state=>state.post);
  const id = useSelector(state => state.user.user?.id);
  //4. dispatch
  const dispatch = useDispatch();
  ////////////////////////////////////////////code
  const{isLogIn} = useSelector(state=>state.user);
  const[comment, onChangeComment]=userInput('');
  const onSubmitForm = useCallback(()=>{
    console.log(post.id, comment);
    dispatch({
      type: ADD_COMMENT_REQUEST,
      data: {content:comment, userId:id, postId:id}
    })
  }, [comment]);

  ////////////////////////////////////////////view
  return(
    <Form onFinish={onSubmitForm} style={{textAlign:'right', marginTop:12, position:'relative'}}>
      <Input.TextArea rows={5} value={comment} onChange={onChangeComment} 
        style={{resize:'none', height:'8em'}} />
      <Button htmlType="submit" type="primary" style={{position:'absolute', right:0, top:80}} loading={addCommentLoading} >댓글</Button>
    </Form>
  )
};

CommentForm.protoType = { post:PropTypes.object.isRequired }
export default CommentForm;