public class ReferenceConstructor {
    
    public static void main(String[] args){
        ReferenceConstructor reference = new ReferenceConstructor();
        reference.makeMemberObject();
    }

    public void makeMemberObject(){
        MemberDTO dto1 = new MemberDTO();
        MemberDTO dto2 = new MemberDTO("name");
        MemberDTO dto3 = new MemberDTO("name", "1234");
        MemberDTO dto4 = new MemberDTO("name", "1234", "asdf");
    }
}
