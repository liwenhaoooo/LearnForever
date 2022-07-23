package com.online_course.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.online_course.server.domain.Member;
import com.online_course.server.domain.MemberExample;
import com.online_course.server.dto.MemberDto;
import com.online_course.server.dto.PageDto;
import com.online_course.server.mapper.MemberMapper;
import com.online_course.server.util.CopyUtil;
import com.online_course.server.util.UuidUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
        import java.util.Date;
@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;
    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        MemberExample memberExample = new MemberExample();
        List<Member> memberList = memberMapper.selectByExample(memberExample);
        PageInfo<Member> pageInfo = new PageInfo<>(memberList);
        pageDto.setTotal(pageInfo.getTotal());
        List<MemberDto> memberDtoList = CopyUtil.copyList(memberList, MemberDto.class);
        pageDto.setList(memberDtoList);
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(MemberDto memberDto) {
        Member member = CopyUtil.copy(memberDto, Member.class);
        if (StringUtil.isEmpty(memberDto.getId())) {
            this.insert(member);
        }else {
            this.update(member);
        }
    }
    /**
     * 新增
     */
    private void insert(Member member) {

                Date now = new Date();
        member.setId(UuidUtil.getShortUuid());
        memberMapper.insert(member);
    }
    /**
     * 更新
     */
    private void update(Member member) {
        memberMapper.updateByPrimaryKey(member);
    }
    /**
     * 删除
     */
    public void delete(String id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}
