import { View, Text, Modal, FlatList, Button, ScrollView, StyleSheet } from 'react-native'
import React, { useEffect, useState } from 'react'
import FormArticle from './FormArticle';

const Exercice02 = (props) => {
  const [courseList, setCourseList] = useState([{ "id": 1710232074582, "name": "Pain" }]);
  const [modal, setModal] = useState(false);
  const addArticle = (article) => {
    const newArticle = {
      id: Date.now(),
      name: article
    }
    setCourseList([...courseList, newArticle]);
    closeModal();
  }
  const showModal = () => {
    setModal(true);
  }
  const closeModal = () => {
    setModal(false);
  }
  useEffect(() => {
    console.log(courseList);
  }, [courseList])
  return (
    <Modal visible={props.visible}>
      <View style={styles.view}>
        <View>
          <Text>Exercice02</Text>
        </View>
        <View>
          <Button title={'Ajouter un article'} onPress={showModal} />
        </View>
        <FormArticle visible={modal} closeModal={closeModal} addArticle={addArticle} />
        <View>
          <Button title='Close' onPress={props.closeModal} />
        </View>
        <View>
          <Text>Ma liste de course :</Text>

          <FlatList
            data={courseList}
            renderItem={(itemData) => {
              <View>
                <Text style={styles.text}>{itemData.item.name}</Text>
              </View>
            }}
            keyExtractor={(item) => item.id}
          />
          <Text>Toto</Text>
        </View>

      </View>
    </Modal>
  )
}

const styles = StyleSheet.create({
  view: {
    flex: 1,
    alignItems: 'center'
  },
  article: {
    height: 200
  },
  text: {
    color: 'black',
    fontSize: 30
  }
})
export default Exercice02