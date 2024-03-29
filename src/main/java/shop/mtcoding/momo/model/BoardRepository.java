package shop.mtcoding.momo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.momo.dto.board.BoardResp;
import shop.mtcoding.momo.dto.board.BoardResp.BoardDetailRespDto;
import shop.mtcoding.momo.dto.board.BoardResp.BoardMainRespDto;

@Mapper
public interface BoardRepository {
        public BoardDetailRespDto findByIdWithUser(int id);

        public List<BoardMainRespDto> findAllWithUser();

        public List<Board> findAll();

        public Board findById(int id);

        public int insert(@Param("title") String title, @Param("content") String content,
                        @Param("thumbnail") String thumbnail,
                        @Param("userId") int userId);

        public int updateById(@Param("id") int id, @Param("title") String title,
                        @Param("content") String content, @Param("thumbnail") String thumbnail);

        public int deleteById(int id);
}