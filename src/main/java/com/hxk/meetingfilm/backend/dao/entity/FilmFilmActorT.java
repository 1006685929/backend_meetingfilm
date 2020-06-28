package com.hxk.meetingfilm.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 影片与演员映射表
 * </p>
 *
 * @author hxk
 * @since 2020-06-08
 */
public class FilmFilmActorT extends Model<FilmFilmActorT> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 影片编号,对应film_film_t
     */
    private Integer filmId;

    /**
     * 演员编号,对应film_actor_t
     */
    private Integer actorId;

    /**
     * 角色名称
     */
    private String roleName;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "FilmFilmActorT{" +
        ", uuid=" + uuid +
        ", filmId=" + filmId +
        ", actorId=" + actorId +
        ", roleName=" + roleName +
        "}";
    }
}
