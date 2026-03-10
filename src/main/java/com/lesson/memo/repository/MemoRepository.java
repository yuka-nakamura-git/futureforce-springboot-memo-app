package com.lesson.memo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lesson.memo.model.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    
	// 優先度順に全件取得（既存）
    List<Memo> findAllByOrderByPriorityAsc();
    
    // タイトル または 内容 にキーワードが含まれているものを検索
    // Containing = 部分一致(LIKE %keyword%), Or = または
    List<Memo> findByTitleContainingOrContentContainingOrderByPriorityAsc(String title, String content);
}