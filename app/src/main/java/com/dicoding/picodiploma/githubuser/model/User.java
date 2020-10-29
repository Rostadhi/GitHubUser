package com.dicoding.picodiploma.githubuser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("login")
    private String login;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("site_admin")
    private boolean siteAdmin;

    @SerializedName("id")
    private int id;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("organizations_url")
    private String organizationsUrl;
    @SerializedName("name")
    private String name;

    public User() {

    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    public User(Parcel in) {
        gistsUrl = in.readString();
        reposUrl = in.readString();
        followingUrl = in.readString();
        starredUrl = in.readString();
        login = in.readString();
        followersUrl = in.readString();
        type = in.readString();
        url = in.readString();
        subscriptionsUrl = in.readString();
        receivedEventsUrl = in.readString();
        avatarUrl = in.readString();
        eventsUrl = in.readString();
        htmlUrl = in.readString();
        siteAdmin = in.readByte() != 0;
        id = in.readInt();
        gravatarId = in.readString();
        nodeId = in.readString();
        organizationsUrl = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gistsUrl);
        dest.writeString(reposUrl);
        dest.writeString(followingUrl);
        dest.writeString(starredUrl);
        dest.writeString(login);
        dest.writeString(followersUrl);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeString(subscriptionsUrl);
        dest.writeString(receivedEventsUrl);
        dest.writeString(avatarUrl);
        dest.writeString(eventsUrl);
        dest.writeString(htmlUrl);
        dest.writeByte((byte) (siteAdmin ? 1 : 0));
        dest.writeInt(id);
        dest.writeString(gravatarId);
        dest.writeString(nodeId);
        dest.writeString(organizationsUrl);
    }


    @SerializedName("bio")
    private String bio;

    @SerializedName("created_at")
    private String createdAt;



    @SerializedName("blog")
    private String blog;



    @SerializedName("updated_at")
    private String updatedAt;


    @SerializedName("company")
    private String company;



    @SerializedName("public_repos")
    private int publicRepos;

    @SerializedName("email")
    private String email;

    @SerializedName("hireable")
    private Object hireable;


    @SerializedName("public_gists")
    private int publicGists;

    @SerializedName("followers")
    private int followers;



    @SerializedName("following")
    private int following;


    @SerializedName("location")
    private String location;





    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }



    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }


    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Object getHireable() {
        return hireable;
    }

    public void setHireable(Object hireable) {
        this.hireable = hireable;
    }


    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }


    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
