import React, { Component } from 'react';
import PropTypes from 'prop-types';
import 'antd/dist/antd.css';
import Head from 'next/head';
import {Provider} from 'react-redux'            //#redux
import wrapper from '../store/configureStore';  //#redux

const TheJoa= ({Component, ...rest})=>{
  ////////////////////////////////////////code
  const {store, props} = wrapper.useWrappedStore(rest);
  const {pageProps}= props;
  ////////////////////////////////////////view
  return(
  <Provider store={store}>
    <Head>
      <meta charset="utf-8" />
      <title>TheJoa</title>
    </Head>
    <Component/>
  </Provider>);
};
TheJoa.propTypes={
  Component:PropTypes.elementType.isRequired,
  pageProps:PropTypes.any.isRequired
}

export default TheJoa;