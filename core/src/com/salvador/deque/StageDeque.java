package com.salvador.deque;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.salvador.deque.Objects.Background;
import com.salvador.deque.Objects.ButtonUI;
import com.salvador.deque.Objects.BoxLine;

import static com.salvador.deque.Values.SCREEN_HIGHT;
import static com.salvador.deque.Values.SCREEN_WIDTH;


public class StageDeque {

    public Stage stage;

    public Background background;

    private BoxLine dequeT;

    private ButtonUI btnAddFront;
    private ButtonUI btnRemoveFront;

    private ButtonUI btnAddBack;
    private ButtonUI btnRemoveBack;

    private SequenceAction sequenceAction;

    private float frontX;

    private float backX;

    private Dequeue deque;

    boolean canAdd = true;

    private DequeueAlgorithm dequeAlgorithm;


    public StageDeque(final Dequeue deque, Stage stage) {
        this.stage = stage;
        this.deque = deque;
        background = new Background(SCREEN_WIDTH * 2, SCREEN_HIGHT);
        stage.addActor(background);

        dequeT = new BoxLine((800 / 2) - 250, (SCREEN_HIGHT / 2) - 30, 500, 60);
        stage.addActor(dequeT);

        frontX = (800 / 2) - 250;

        backX = (800 / 2) - 250;

        btnAddFront = new ButtonUI(50, 225+50, 70, 70);
        btnRemoveFront = new ButtonUI(50, 225-50-70, 70, 70);

        btnAddBack = new ButtonUI(800-120, 225+50, 70, 70);
        btnRemoveBack = new ButtonUI(800-120, 225-50-70, 70, 70);

        Texture txeAdd = new Texture(Gdx.files.internal("btnAdd.png"));
        Texture txeRemove = new Texture(Gdx.files.internal("btnRemove.png"));

        btnAddFront.setTexture(txeAdd);
        btnRemoveFront.setTexture(txeRemove);
        btnAddBack.setTexture(txeAdd);
        btnRemoveBack.setTexture(txeRemove);

        stage.addActor(btnAddFront);
        stage.addActor(btnRemoveFront);

        stage.addActor(btnAddBack);
        stage.addActor(btnRemoveBack);

        dequeAlgorithm = new DequeueAlgorithm();


        btnAddFront.setOnClickListenner(new ButtonUI.OnClickListenner() {
            @Override
            public void onClick() {
                if(canAdd) {
                    canAdd = false;

                    final NodeD node = new NodeD((SCREEN_WIDTH / 2) - 48, 80, 48, 48);
                    StageDeque.this.stage.addActor(node);

                    SequenceAction sequenceAction = new SequenceAction();
                    sequenceAction.addAction(Actions.moveTo(60, 80, 1f));
                    sequenceAction.addAction(Actions.moveTo(60, (SCREEN_HIGHT / 2) - 24, 1f));
                    sequenceAction.addAction(Actions.moveTo(frontX, (SCREEN_HIGHT / 2) - 24, 1f));

                    RunnableAction runnableAction = new RunnableAction();
                    runnableAction.setRunnable(new Runnable() {
                        @Override
                        public void run() {
                            dequeAlgorithm.pushFront(node);
                            canAdd = true;
                        }
                    });
                    sequenceAction.addAction(runnableAction);
                    node.addAction(sequenceAction);

                    NodeD temp = dequeAlgorithm.getFront();

                    while (temp != null) {
                        temp.addAction(Actions.moveTo(temp.getX() + 48, (SCREEN_HIGHT / 2) - 24, 1f));
                        temp = temp.next;
                    }

                    backX += 48;

                }
            }
        });

        btnRemoveFront.setOnClickListenner(new ButtonUI.OnClickListenner() {
            @Override
            public void onClick() {
                NodeD front = dequeAlgorithm.popFront();

                if(front != null){
                    sequenceAction = new SequenceAction();
                    sequenceAction.addAction(Actions.moveTo(-100, front.getY(), 1f));
                    front.addAction(sequenceAction);

                    front = front.next;
                    backX -= 48;

                    NodeD temp = front;

                    while(temp != null){
                        temp.addAction(Actions.moveTo(temp.getX()-48, (SCREEN_HIGHT / 2) - 24, 1f));
                        temp = temp.next;
                    }


                }

            }
        });

        btnAddBack.setOnClickListenner(new ButtonUI.OnClickListenner() {
            @Override
            public void onClick() {
                NodeD node  = new NodeD((SCREEN_WIDTH/2)-48,80,48,48);
                StageDeque.this.stage.addActor(node);

                sequenceAction = new SequenceAction();
                sequenceAction.addAction(Actions.moveTo(700,  node.getY(), 1f));
                sequenceAction.addAction(Actions.moveTo(700,  (SCREEN_HIGHT/2) - 24, 1f));
                sequenceAction.addAction(Actions.moveTo(backX, (SCREEN_HIGHT / 2) - 24, 1f));

                node.addAction(sequenceAction);
                backX += 48;

                dequeAlgorithm.pushBack(node);
            }
        });

        btnRemoveBack.setOnClickListenner(new ButtonUI.OnClickListenner() {
            @Override
            public void onClick() {

                NodeD back = dequeAlgorithm.popBack();

                if(back != null){
                    sequenceAction = new SequenceAction();
                    sequenceAction.addAction(Actions.moveTo(1000, back.getY(), 1f));
                    back.addAction(sequenceAction);
                    backX -= 48;
                    back = back.prev;
                }
            }
        });
    }


}
