import React, {useState, useCallback} from "react";


export default ( initialValue=null )=>{
  const [value, setValue] = useState(initialValue);
  const handler = useCallback((e)=>{ setValue(e.target.value) }, [] );

  return [value, handler];
};


//  const [id, setId] = useState('');
//  const onChangeId = useCallback((e)=>{ setId(e.target.value) }, [] );

//  const [nickname, setNickname] = useState('');
//  const onChangeNickname = useCallback((e)=>{ setNickname(e.target.value) }, [] );  