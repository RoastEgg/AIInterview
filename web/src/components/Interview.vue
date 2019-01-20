<template>
    <div class="container">
        <div class="user-list">
            <div
                    v-for="(person,index) in persons" :key=" index"
                    @click="clickPerson(person,index)">
                <div v-if="index == currentIndex" class="user-item user-item-selected">
                    <p>{{person.name}}</p>
                    <div class="line"></div>
                </div>
                <div v-else class="user-item">
                    <p>{{person.name}}</p>
                    <div class="line"></div>
                </div>
            </div>
        </div>

        <div class="user-detail">
            <div class="user-info">
                <div class="user-info-avatar"></div>
                <div class="user-info-p">
                    <p class="user-info-name">{{currentPerson.name}}</p>
                    <p class="user-info-more">{{currentPerson.organization}}</p>
                </div>
            </div>
            <div class="video-wrapper">
                <video
                        id="myVideo"
                        :src="currentPerson.videoPath"
                        controls autoplay="autoplay">
                    <source src="http://minkbooks.com/content/trailer.mp4">
                </video>
            </div>
            <div class="evaluates">
                <div class="evaluate">
                    <p class="key">形象气质</p>
                    <p class="value">{{currentPerson.face}}</p>
                </div>
                <div class="evaluate">
                    <p class="key">亲和力</p>
                    <p class="value">{{currentPerson.affinity}}</p>
                </div>
                <div class="evaluate">
                    <p class="key">自信力</p>
                    <p class="value">{{currentPerson.confidence}}</p>
                </div>
                <div class="evaluate">
                    <p class="key">情绪稳定</p>
                    <p class="value">{{currentPerson.stability}}</p>
                </div>
                <div class="evaluate">
                    <p class="key">表达能力</p>
                    <p class="value">{{currentPerson.expression}}</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      currentIndex: 0,
      currentPerson: {
        id: 0,
        name: 'name',
        organization: 'nanjingdaxue',
        filePath: '',
        applyPurpose: 0,//求职动机
        affinity: 0,//亲和力
        aotugnosis: 0,//自我认知
        confidence: 0,//自信力
        expression: 0,//表达能力
        face: 0,//形象气质
        stability: 0,//情绪稳定
        detail: {}
      },
      persons: [{
        id: 1,
        name: '赵大华',
      }, {
        id: 2,
        name: '马连良',
      }, {
        id: 3,
        name: '陈文斌',
      }, {
        id: 4,
        name: '沈萍',
      }, {
        id: 5,
        name: '沈亚楠',
      }]
    }
  },
  mounted () {
    let self = this
    fetch('http://47.101.49.230:9080/interviewee/getInterviewees')
      .then(res => res.json())
      .then((res) => {
        let persons = res.map((name, index) => {
          return {
            id: index,
            name: name
          }
        })
        self.persons = persons
        self.fetchOnePerson(persons[0].name)
      })
  },
  methods: {
    clickPerson (person, index) {
      if (index != this.currentIndex) {
        this.currentIndex = index
        this.currentPerson = person
        this.fetchOnePerson(person.name)
      }
    },
    fetchOnePerson (name) {
      // console.log(name)
      let self = this
      fetch('http://47.101.49.230:9080/interviewee/getDescAndScore?name=' + name, {
        method: 'POST',
        headers: {
          'content-type': 'application/x-www-form-urlencoded'
        },
      })
        .then((res) => res.json())
        .then((res) => {
          // console.log(res)
          let videoPath = res.filePath
          videoPath = encodeURI('http://47.101.49.230:9080/interviewee/videos/' + videoPath.substring(videoPath.lastIndexOf('/') + 1))
          let person = { ...res, id: 0, name: name, videoPath: videoPath }
          // console.log(person)
          self.currentPerson = person
        })
    }
  }
}
</script>

<style>
    body {
        margin: 0;
    }

    p {
        margin: 0;
    }

    .container {
        width: 100vw;
        height: 100vh;
        position: relative;
        /* display: flex;
        flex-direction: row;
        align-items: flex-start; */
    }

    .user-list {
        position: absolute;
        left: 0;
        top: 0;
        font-size: 1rem;
        width: 6rem;
        text-align: center;
        background: rgb(62, 58, 57);
        z-index: 99;
        max-height: 100%;
        overflow: scroll
    }

    .user-item {
        height: 3rem;
        padding-top: 20px;
        display: flex;
        color: white;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .line {
        margin-top: 0.8rem;
        width: 4rem;
        height: 0.2rem;
        background: rgb(88, 88, 88);
        border-radius: 0.1rem;
    }

    .user-item-selected {
        background: rgb(100, 182, 115);
    }

    .user-item-selected .line {
        background: rgb(81, 154, 91);
    }

    .user-detail {
        width: 100%;
        min-height: 100vh;
        position: absolute;
        left: 0;
        top: 0;
        padding-left: 6rem;
        /* padding: 6rem; */
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        justify-content: flex-start;
        background: rgb(242, 242, 242);
        box-sizing: border-box;
    }

    .user-info {
        padding: 1rem 1.2rem;
        height: 5rem;
        width: 100%;
        display: flex;
        flex-direction: row;
        align-items: center;
        color: white;
        background: rgb(81, 154, 91);
    }

    .user-info-avatar {
        width: 4rem;
        height: 4rem;
        margin: 1rem 1rem 1rem 0;
        border-radius: 50%;
        background: #ccc;
    }

    .user-info-text {
        font-size: 32px;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .user-info-name {
        font-size: 1.4rem;
    }

    .user-info-more {
        font-size: 1rem;
    }

    .video-wrapper {
        width: 100%;
        padding: 20px;
        box-sizing: border-box;
    }

    #myVideo {
        width: 100%;
        height: 10rem;
    }

    .evaluate {
        padding-left: 1.2rem;
        height: 2rem;
        display: flex;
        font-size: 1.2rem;
    }

    .evaluate .key {
        width: 200px;
    }

    .evaluate .value {
        color: #666;
    }
</style>
