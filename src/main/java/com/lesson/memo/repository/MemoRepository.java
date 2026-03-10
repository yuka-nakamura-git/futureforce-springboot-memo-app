package com.lesson.memo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lesson.memo.model.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 優先度(Priority)の順序（HIGH > MEDIUM > LOW）で並び替えて取得するメソッドを追加
    List<Memo> findAllByOrderByPriorityAsc();
}