package com.project.brunch.web.dto.follow;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowCountDto {
	private List<FollowRespDto> followRespDto;
	private int followCount; 
}
