<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="<c:url value='/resources/css/reservation/book_seat_spot.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/jquery.min.js'></c:url>"></script>
<main>
	<div class="container">
		<!-- 주문과정/절차 -->
		<div class="procedure_container clearfix">
			<h1 class="procedure_title">바로예약 [좌석]</h1>
			<ul class="detail_procedure">
				<li class="item_procedure  selected">
					<div class="numbering">01</div>
					<span class="item_text">지점 선택</span>
				</li>
				<i class="icon_next"></i>
				<li class="item_procedure">
					<div class="numbering">02</div>
					<span class="item_text">좌석,이용권 선택</span>
				</li>
				<i class="icon_next"></i>
				<li class="item_procedure">
					<div class="numbering">03</div>
					<span class="item_text">예약완료</span>
				</li>
			</ul>					
		</div>
		<div class="seat_container">
			<!-- 필터 섹션 -->
			<section>
				<div class="search_container">
					<div class="filter_area">
					<form action="<c:url value='/reservation/1/spot'></c:url>" method="post" style="display:flex;">
						<select class="choose_region" name="br_re_name">
							<option value="" <c:if test="${region==''}">selected</c:if>>지역 선택</option>
							<option value="지역 미지정" <c:if test="${region=='지역 미지정'}">selected</c:if>>지역 미지정</option>
							<option value="서울특별시" <c:if test="${region=='서울특별시'}">selected</c:if>>서울특별시</option>
							<option value="인천광역시" <c:if test="${region=='인천광역시'}">selected</c:if>>인천광역시</option>
							<option value="대구광역시" <c:if test="${region=='대구광역시'}">selected</c:if>>대구광역시</option>
							<option value="대전광역시" <c:if test="${region=='대전광역시'}">selected</c:if>>대전광역시</option>
							<option value="부산광역시" <c:if test="${region=='부산광역시'}">selected</c:if>>부산광역시</option>
							<option value="광주광역시" <c:if test="${region=='광주광역시'}">selected</c:if>>광주광역시</option>
							<option value="울산광역시" <c:if test="${region=='울산광역시'}">selected</c:if>>울산광역시</option>
							<option value="경기도" <c:if test="${region=='경기도'}">selected</c:if>>경기도</option>
							<option value="강원도" <c:if test="${region=='강원도'}">selected</c:if>>강원도</option>
							<option value="경상북도" <c:if test="${region=='경상북도'}">selected</c:if>>경상북도</option>
							<option value="경상남도" <c:if test="${region=='경상남도'}">selected</c:if>>경상남도</option>
							<option value="전라북도" <c:if test="${region=='전라북도'}">selected</c:if>>전라북도</option>
							<option value="전라남도" <c:if test="${region=='전라남도'}">selected</c:if>>전라남도</option>
							<option value="충청북도" <c:if test="${region=='충청북도'}">selected</c:if>>충청북도</option>
							<option value="충청남도" <c:if test="${region=='충청남도'}">selected</c:if>>충청남도</option>
							<option value="제주특별자치도" <c:if test="${region=='제주특별자치도'}">selected</c:if>>제주특별자치도</option>
							<option value="세종특별자치시" <c:if test="${region=='세종특별자치시'}">selected</c:if>>세종특별자치시</option>
						</select>
						<div class="search_box">
							<input type="search" class="search" name="br_name" placeholder="지역, 지점명으로 검색" value="${keyword}">
							<button class="btn_search"><i class="icon_search"></i></button>
						</div>
					</form>
					</div>
				</div>
					
			</section>
			<!-- 지점 카드 -->
			<section>
				<div class="spot_card_container">
					<ul class="list_card">
					<c:if test="${brList.size()==0}"> 검색 결과가 없습니다.</c:if>
					<c:if test="${brList.size()!=0}">
						<c:forEach begin="0" end="${brList.size()-1}" step="3" var="i">
							<div class="row_card clearfix">
								<c:forEach begin="${i}" end="${i+2}" var="index">
									<c:if test="${brList.size()-1 >= index}">
										<li class="item_card add_shadow">
											<a href="<c:url value='/reservation/1/${brList.get(index).br_num}'></c:url>">
												<div class="img-box"></div>
												<div class="info_area">
													<h2>${brList.get(index).br_name}</h2>
													<span class="spot_address">${brList.get(index).br_road_address}</span>
													<div class="info_running_time">
														<span>수용인원</span>
														<span class="hour">${brList.get(index).br_capacity}</span>명
														<span class="holiday">24시간 연중무휴</span>
													</div>
												</div>
											</a>
										</li> 
									</c:if>
								</c:forEach>
							</div>
						</c:forEach>
					</c:if>	
					</ul>
					<div class="page_box clearfix">
						<i class="btn_prev"></i>
						<span class="page_num selected_num">1</span>
						<span class="page_num">2</span>
						<span class="page_num">3</span>
						<span class="page_num">4</span>
						<span class="page_num">5</span>
						<i class="btn_next"></i>
					</div>
				</div>
			</section>
		</div>
	</div>
</main>
<script>

</script>