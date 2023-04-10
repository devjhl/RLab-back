package kr.kh.RLab.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.RLab.pagination.Criteria;
import kr.kh.RLab.vo.BoardVO;
import kr.kh.RLab.vo.ScrapVO;

public interface ScrapDAO {
    ScrapVO findScrap(ScrapVO scrapVO);
    void insertScrap(ScrapVO scrapVO);
    void updateScrap(ScrapVO scrapVO);
    int getScrapCountByBoard(int bo_num);
    



}
