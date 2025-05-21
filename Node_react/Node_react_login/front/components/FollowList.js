import { List, Button, Card } from "antd";
import React, {useMemo} from "react";
import {PlusOutlined, UserDeleteOutlined} from '@ant-design/icons'

const FollowList = ({header, data})=>{
  ////////////////////////////////code
  const style = useMemo( () => ({margin:'3%', backgroundColor:'white', padding:'3%'}),  [] );

  ////////////////////////////////view
  return(
  <List style={style}
  grid={{gutter:4, xs:2, md:4}} size="small" header={<div>{header}</div>} 
  loadMore={<div style={{textAlign:'center'}}><Button>더보기</Button></div>} 
  dataSource={data}
  renderItem={(item)=>( // map* :: ()=>()
    <List.Item>
      <Card actions={[ <UserDeleteOutlined key="user"/> ]}>
        <Card.Meta description={item.nickname}/>
      </Card>
    </List.Item>
  )}
  >
  
  </List>
  );
}

export default FollowList;