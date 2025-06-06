import React , {useMemo, useState} from 'react';
import { List, Button, Card } from 'antd';
import { UserDeleteOutlined } from '@ant-design/icons';
import { useDispatch } from 'react-redux';
import { UNFOLLOW_REQUEST, REMOVE_FOLLOWER_REQUEST } from '../reducers/user';

//             팔로잉,팔로우  팔로잉리스트/팔로우리스트   3개이벤트 각각 로딩
const FollowList = ({ header, data, onClikMore, loading }) => {
  const style = useMemo(() => ({
    margin:'3%' , backgroundColor:'white' , padding:'3%'
  }) , []);
  ///////////////////////////////// code 
  const dispatch = useDispatch();
  const [localData, setLocalData] = useState(data);
  const onClickCancel = (id) => () => {
    setLocalData( (prev)=>prev.filter( (user)=> user.id !== id ) )
    if(header === '팔로잉'){
      dispatch({  type:UNFOLLOW_REQUEST, data: id  });
    }else{
      dispatch({ type:REMOVE_FOLLOWER_REQUEST, data:id });
    }
  }
  ///////////////////////////////// view
  return (<List  style={style}
    grid ={{ gutter : 4 , xs : 2, md: 3 }}
    size="small"
    header={<div> {header} </div>}
    loadMore={<div style={{ textAlign: 'center' }} >
      <Button onClick={onClikMore} loading={loading} >더보기</Button></div>}
    dataSource={localData}  
    renderItem={(item)=>(
    <List.Item>
      <Card actions={[<UserDeleteOutlined  key="user" onClick={onClickCancel(item.id)} />]}>
        <Card.Meta  description={item.nickname}   />
      </Card>
    </List.Item>
   )}
  />
  )
 };  // https://ant.design/components/icon?locale   ()=>{}  , ()=>()

export default FollowList;