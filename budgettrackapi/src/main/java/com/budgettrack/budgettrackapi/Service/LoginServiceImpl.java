package com.budgettrack.budgettrackapi.Service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgettrack.budgettrackapi.Common.APIResponse;
import com.budgettrack.budgettrackapi.Constants.CommonConstants;
import com.budgettrack.budgettrackapi.DTO.ForgetPasswordReqDTO;
import com.budgettrack.budgettrackapi.DTO.LoginRequestDTO;
import com.budgettrack.budgettrackapi.DTO.SignUpRequestDTO;
import com.budgettrack.budgettrackapi.Entity.UserEntity;
import com.budgettrack.budgettrackapi.Repository.UserRepository;
import com.budgettrack.budgettrackapi.Util.JwtUtils;

@Service
public class LoginServiceImpl implements LoginService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public UserEntity getUserById(Long userId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		return userOptional.orElse(null); // Return null if user is not found, handle it as needed
	}

	@Override
	public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {

		APIResponse apiResponse = new APIResponse();
		HashMap<String, Object> resultDataMap = new HashMap<>();
		
		if(!userRepository.findByMobileNumber(signUpRequestDTO.getMobileNo()))
		{
			UserEntity userEntity = new UserEntity();
			userEntity.setUserName(signUpRequestDTO.getUserName());
			userEntity.setMobileNo(signUpRequestDTO.getMobileNo());
			userEntity.setPassword(signUpRequestDTO.getPassword());
			userEntity.setActive(true);
			userEntity = userRepository.save(userEntity);
			
			String tokenData = jwtUtils.generateJwt(userEntity);			
			resultDataMap.put(CommonConstants.ACCESS_TOKEN, tokenData);	
			resultDataMap.put(CommonConstants.RESULT_STATUS, "Success");
			apiResponse.setData(resultDataMap);
			
//			apiResponse.setData(userEntity);
		}
		else {			
			resultDataMap.put(CommonConstants.RESULT_STATUS, "Mobile No Already Exists");
			apiResponse.setData(resultDataMap);
		}
		
		return apiResponse;
	}

	
	@Override
	public APIResponse login(LoginRequestDTO loginRequestDTO) {
		
		APIResponse apiResponse = new APIResponse();
		HashMap<String, Object> resultDataMap = new HashMap<>();
		try {
			UserEntity userEntity= userRepository.validLogin(loginRequestDTO.getMobileNo(), loginRequestDTO.getPassword());
			if(userEntity == null)
			{
				System.out.println("User Entity Null");
				resultDataMap.put(CommonConstants.RESULT_STATUS, "Login Failed!");	
				apiResponse.setData(resultDataMap);	
				return apiResponse;
			}
			
			String tokenData = jwtUtils.generateJwt(userEntity);
			
			resultDataMap.put(CommonConstants.ACCESS_TOKEN, tokenData);
			resultDataMap.put(CommonConstants.RESULT_STATUS, "Success");
			
			apiResponse.setData(resultDataMap);
			return apiResponse;
		}
		catch(Exception e)
		{			
			apiResponse.setError(e.getMessage());
			return apiResponse;
		}
		
	}
	
	public APIResponse forgetPasswordService(ForgetPasswordReqDTO forgetPasswordReqDTO)
	{
		APIResponse apiResponse = new APIResponse();
		HashMap<String, Object> resultDataMap = new HashMap<>();
		try {
			UserEntity userEntity= userRepository.forgetPasswordRepo(forgetPasswordReqDTO.getMobileNo());
			if(userEntity != null)
			{
				String tokenData = jwtUtils.generateJwt(userEntity);
				resultDataMap.put(CommonConstants.ACCESS_TOKEN, tokenData);
				resultDataMap.put(CommonConstants.RESULT_STATUS, "Success");
				resultDataMap.put(CommonConstants.RESULT_VALUE, userEntity.getPassword());	
				apiResponse.setData(resultDataMap);	
				return apiResponse;
			}
			else
			{
				resultDataMap.put(CommonConstants.RESULT_STATUS, "Failed");
				resultDataMap.put(CommonConstants.RESULT_VALUE, "Mobile No Not Available");
				return apiResponse;
			}
			}
			catch(Exception e)
			{
				apiResponse.setError(e.getMessage());
				return apiResponse;
			}
	}
	

}
