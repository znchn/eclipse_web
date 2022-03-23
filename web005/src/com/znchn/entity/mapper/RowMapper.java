package com.znchn.entity.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {

	public T rowMap(ResultSet rs) throws Exception;
}
