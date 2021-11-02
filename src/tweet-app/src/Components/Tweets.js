const Tweets = (tweetList) => {
    let tweets = tweetList.items;

    if(tweets === {}) {
        return <p>No Tweets made by the user.</p>
    }else {
        Object.entries(tweets).map(([key, value]) => console.log(key, value[0], value[1]));
        return (<table>
            <thead>
                <tr>
                    <th>TweetID</th>
                    <th>Tweet</th>
                    <th>Timestamp</th>
                </tr>
            </thead>
            <tbody>
                {Object.entries(tweets).map(([key, value]) => {
                    return (<tr>
                    <td>{key}</td>
                    <td>{value[0]}</td>
                    <td>{value[1]}</td>
                    </tr>)
                })}
            </tbody>
        </table>);
    }
}
export default Tweets;