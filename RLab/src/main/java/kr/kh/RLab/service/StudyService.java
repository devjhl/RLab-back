package kr.kh.RLab.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.RLab.vo.FileVO;
import kr.kh.RLab.vo.MemberVO;
import kr.kh.RLab.vo.PhotoTypeVO;
import kr.kh.RLab.vo.PhotoVO;

public interface StudyService {

	ArrayList<PhotoTypeVO> getListPhotoType();

	boolean insertCB(PhotoVO photo, MultipartFile[] files, MemberVO member);

}
