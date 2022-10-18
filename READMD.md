# SNS With TDD

```java
@Test
public void 회원가입() throws Exception {
    String userName = "kyeongrok";
    String password = "1q2w3e4r";

    // mock생성
    when(userService.join()).thenReturn(mock(User.class));

    mockMvc.perform(post("/api/v1/users/join")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password)))
            ).andDo(print())
            .andExpect(status().isOk());
}
```