import axios from "axios";

const PostTweet = () => {
    function handlePost(e) {
        let formData = new FormData();
        formData.append('username', sessionStorage.getItem('user'));
        formData.append('tweet', e.target.form.tweet.value)
        axios.post('http://localhost:8080/post', formData)
            .then(response => {
                console.log(response.data);
            })
            .catch(function(error){
                if(error.response){
                    console.log(error.response.status);
                }
            })
    }

    return (
        <div className="Post">
            <form className="form">
                <div className="input-group">
                    <label htmlFor="Tweet">Tweet</label>
                    <input type="text" id="tweet" name="tweet" placeholder="What do you want to tweet about?" />
                </div>
                <button type="button" className="primary" onClick={handlePost}>Submit Tweet</button>
            </form>
        </div>
    );
}
export default PostTweet;