//package com.online_gaming_service.gaming_service_application.services;
//
//import java.util.ArrayList;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.online_gaming_service.gaming_service_application.dto.LeaderboardResponseDTO;
//import com.online_gaming_service.gaming_service_application.entities.User;
//import com.online_gaming_service.gaming_service_application.repositories.UserRepository;
//
//@Service
//public class UserScoreMapping {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	public List<LeaderboardResponseDTO> mapScoreWithUserName(Set<String> set) {
//		Iterator setData = set.iterator();
//		ArrayList<String> listValues = new ArrayList<>();
//		while (setData.hasNext()) {
//			listValues.add(setData.next().toString());
//		}
//
//		List<LeaderboardResponseDTO> leaderboardList = new ArrayList<>();
//		System.out.println("Lets start 1111     " + listValues);
//		for (int i = 0; i < listValues.size(); i++) {
//			LeaderboardResponseDTO leaderboardResponseDTO = new LeaderboardResponseDTO();
//			String infoValue = listValues.get(i);
//			int firstIndex = infoValue.indexOf("=");
//			int lastIndex = infoValue.lastIndexOf("=");
//			int middleIndex = infoValue.indexOf(",");
//			int middleIndex1 = infoValue.lastIndexOf("]");
//			System.out.println("Lets start22  " + infoValue.substring(firstIndex+1, middleIndex));
//			System.out.println("Middle start22 " + Double.parseDouble(infoValue.substring(firstIndex+1, middleIndex)));
////			System.out.println("Middle start33 " + Long.parseLong(infoValue.substring(firstIndex+1, middleIndex)));
//			leaderboardResponseDTO.setTotalScoresValue(Double.parseDouble(infoValue.substring(firstIndex+1, middleIndex)));
//			System.out.println("Lets start33  " + infoValue.substring(lastIndex+1, middleIndex1));
//			Long userIdInfo = Long.parseLong(infoValue.substring(lastIndex+1, middleIndex1));
//			System.out.println("Lets start44  " + userIdInfo);
//			Optional<User> userInfo = userRepository.findById(userIdInfo);
//			String userNameValue = "NA";
//			if(!userInfo.isEmpty()) {
//				System.out.println("Lets start55  " + userInfo);
//				userNameValue = userInfo.get().getFirstName() + " " + userInfo.get().getLastName();
//			}
//			System.out.println("Lets start66  " + userNameValue);
//			leaderboardResponseDTO.setUserNameInfo(userNameValue);
//			System.out.println("Lets start77  " + leaderboardResponseDTO);
//			leaderboardList.add(leaderboardResponseDTO);
//			
//			System.out.println("LetsMakee_______  " + leaderboardList);
//		}
//		System.out.println("Lets start88  " + leaderboardList);
//		return leaderboardList;
//	}
//
//}
