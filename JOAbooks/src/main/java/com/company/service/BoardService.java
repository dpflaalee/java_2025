package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	public void exec(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;


}


/*
        <<interface>> BoardService   - exec(request, response)   
   ↑             ↑            ↑            ↑            ↑           ↑  
   BList   BWrite        BDetail     BEditView     BEdit       BDelete   

>   BList     전체리스트   -  dao.list()
>   BWrite    글삽입       -  dao.insert(dto)  / 알림창- 성공/실패
>   BDetail   상세보기     -  dao.updateHit(dto) , dao.detail(dto)
>   BEditView 글수정폼   -  dao.detail(dto)
>   BEdit     글수정        -  dao.update(dto)  / 알림창- 성공/실패
>   BDelete   해당글삭제-  dao.delete(dto)  / 알림창- 성공/실패
*/