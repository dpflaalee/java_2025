import React, {useState, useCallback} from 'react';
import { Card, Avatar, Button , List, Comment  , Popover } from 'antd';
import { EllipsisOutlined, HeartOutlined, HeartTwoTone, MessageOutlined, MessageTwoTone, RetweetOutlined } from '@ant-design/icons';
import PostImages from './PostImages';
import CommentForm from './CommentForm';
import { useSelector } from 'react-redux';

const PostCard = ({post}) => { 
  ////////////////////////////////////////////code
  const id = useSelector( (state)=>(state.user.user?.id) );
  console.log(id);

  //1. 좋아요-false
  const[like, setLike]=useState(false);
  const onClickLike = useCallback( ()=>{setLike( (prev)=>!prev); }, [] );
  
  //2. 댓글
  const[com, setCom]=useState(false);
  const onClickComment = useCallback(()=>{setCom((prev)=>!prev)},[]);
  ////////////////////////////////////////////view
  return (<div  style={{margin:'3%'}}>
    <Card 
      cover={post.Images && post.Images.length > 0 &&
             <PostImages images={post.Images} />}
      actions={[
        <RetweetOutlined key="retweet" />, 
        like
          ?<HeartTwoTone twoToneColor="#f00" key="heart" onClick={onClickLike}/>
          :<HeartOutlined key="heart" onClick={onClickLike} />,

        <MessageOutlined key="comnetButton" onClick={onClickComment} />,
        <Popover content={(
          <Button.Group>
            { id&&id === post.User.id
            ?(<>
              <Button>수정</Button>
              <Button  type="primary">삭제</Button>
            </>)
            :  <Button type='danger'>신고</Button>
            }
          </Button.Group>
        )}>
          <EllipsisOutlined/>
        </Popover>
      ]}
    >
      <Card.Meta avatar={<Avatar>{post.User.nickname[0]}</Avatar>}
                 title={post.User.nickname}
                 description={post.content} />
    </Card>

    {com && (
    <>
      {/* 댓글 폼 */}
       <CommentForm post={post}/>
      {/* 댓글 리스트 */}
      <List
        header={`${post.Comments.length}댓글`}
        itemLayout='horizontal'
        dataSource={post.Comments}
        renderItem={(item)=>(
          <li>
            <Comment
              avatar={<Avatar>{item.User.nickname[0]}</Avatar>}
              content={item.content}
              author={item.User.nickname}
            />
          </li>
        )
        }
      />
    </>
    )}
  </div>);
};
export default PostCard;