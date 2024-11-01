package edu.kh.todo.model.service;

import java.util.Map;

import edu.kh.todo.model.dto.Todo;

public interface TodoService {
	
	
	/** (TEST) totoNo 가 1인 할 일 제목 조회
	 * @return title
	 */
	String testTitle();

	/** 할 일 목록 + 완료된 할 일 갯수 조회
	 * @return map
	 */
	Map<String, Object> selectAll();

	/** 할 일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 */
	int addTodo(String todoTitle, String todoContent);



	
	/** 완료 여부 변경 
	 * @param todo
	 * @return
	 */
	int changeComplete(Todo todo);

	/** 할 일 상세 조회
	 * @param todo
	 * @return todo
	 */
	Todo todoDetail(int todoNo);

	int delTodo(int todoNo);

	int update(String todoTitle, String todoContent, int todoNo);



}
