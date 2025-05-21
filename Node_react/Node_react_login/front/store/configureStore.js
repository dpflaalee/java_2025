import React from "react";
import {createWrapper} from 'next-redux-wrapper';
import { createStore, applyMiddleware, compose } from "redux";
import {composeWithDevTools} from 'redux-devtools-extension';
import reducer from '../reducers/index'

const configureStore = ()=>{
  const middlewares =[];
  const enhancer = process.env.NODE_ENV === 'production' ? 
        compose([...middlewares]) : composeWithDevTools(applyMiddleware(...middlewares));
  const store = createStore(reducer, enhancer);
  return store;
};//E.configureStore
const wrapper = createWrapper( configureStore, {
  debug:process.env.NODE_ENV === 'development',
} );//E.Wrapper

export default wrapper;