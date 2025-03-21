package com.example.springminipractice.repository;

import com.example.springminipractice.dto.MemberResponseDto;
import com.example.springminipractice.entity.Member;
import com.example.springminipractice.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemberRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MemberResponseDto signUp(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",member.getName());
        parameters.put("age",member.getAge());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        if(key.longValue()>10){
            throw new CustomException("정원초과입니다.");
        } else {
            return new MemberResponseDto(key.longValue(), member.getName(), member.getAge());
        }
    }

    @Override
    public Member check(String name) {
        List<Member> result = jdbcTemplate.query(
                "select * from member where name = ?",
                memberRowMapper(), name);

        if(!result.isEmpty()){
            throw new CustomException("해당 이름이 존재합니다.");
        } else {
            throw new CustomException("사용 가능한 이름입니다.");
        }
    }


    private RowMapper<Member> memberRowMapper() {
        return new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Member(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
            }
        };
    }

}
