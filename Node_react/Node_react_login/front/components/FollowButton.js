import { Button } from "antd"; //부품객체
import React, {useCallback} from "react"; // 디자인
import PropTypes from "prop-types"; // 넘겨받은 파라미터 데이터
import { useSelector, useDispatch } from "react-redux"; //중앙저장소 
import { FOLLOW_REQUEST, UNFOLLOW_REQUEST } from "../reducers/user"; //액션타입

//function FollowButton(){}
const FollowButton = ({post})=>{
//////////////////////////////////////////////code
const dispatch = useDispatch();
const{user, followLoading, unfollowLoading} = useSelector(state=>state.user);
//팔로잉하는 사람들 목록 중에 아이디가 존재하는지 - 팔로잉 여부
const isFollowing = user?.Followings.find( (v) => v.id===post.User.id );
const onClickFollow = useCallback( ()=>{
  if(isFollowing){ // 팔로잉-내친구-언팔로우
    dispatch({
      type: UNFOLLOW_REQUEST, data: post.User.id });
  }else{ //팔로우
    dispatch({ type:FOLLOW_REQUEST, data: post.User.id });
  }
} , [isFollowing] );
//////////////////////////////////////////////view
  return(<Button loading={ followLoading || unfollowLoading } onClick={onClickFollow} >
    {isFollowing? '언팔로우' : '팔로우' }
  </Button>);
};

FollowButton.propTypes = {
  post: PropTypes.object.isRequired,
}
export default FollowButton;